from application import ABC, abstractmethod
from application import new_uuid, datetime
from application import os, json

from application import pandas

ENCODING = 'UTF-8'

PROJECT_ROOT = os.path.join(os.curdir)
DATABASE_FOLDER = 'notes'
LOGS_FOLDER = 'logs'


class Note(ABC):

    @property
    @abstractmethod
    def title(self) -> str:
        ...

    @property
    @abstractmethod
    def body(self) -> str:
        ...

    @property
    @abstractmethod
    def uuid(self) -> str:
        ...

    @property
    @abstractmethod
    def timestamp(self) -> datetime:
        ...


class NoteFile(Note):

    def __init__(self, title: str = 'No title', body: str = 'No content', uuid: str = '',
                 timestamp: float = None) -> None:
        if uuid:
            self.uuid: str = uuid
        else:
            self.generate_uuid()

        self.timestamp: datetime = (datetime.fromtimestamp(timestamp).replace(microsecond=0) if timestamp
                                    else datetime.now().replace(microsecond=0))

        self.title: str = title
        self.body: str = body

    @property
    def title(self) -> str:
        return self.__title

    @title.setter
    def title(self, title: str) -> None:
        self.__title = title

    @property
    def body(self) -> str:
        return self.__body

    @body.setter
    def body(self, body: str) -> None:
        self.__body = body

    @property
    def timestamp(self) -> datetime:
        return self.__timestamp

    @timestamp.setter
    def timestamp(self, timestamp: datetime) -> None:
        self.__timestamp = timestamp

    @property
    def uuid(self) -> str:
        return self.__uuid

    @uuid.setter
    def uuid(self, uuid: str) -> None:
        self.__uuid = uuid

    def generate_uuid(self):
        self.uuid = str(new_uuid())

    def to_dict(self) -> dict:
        return dict(timestamp=self.timestamp,
                    uuid=self.uuid,
                    title=self.title,
                    body=self.body)

    def __str__(self):
        return (f'Дата: {self.timestamp}\n'
                f'UUID: {self.uuid}\n'
                f'Заголовок: {self.title}\n'
                f'Содержание: {self.body}')


class DataBase:

    def __init__(self, db_folder: str = DATABASE_FOLDER, table_name: str = 'db.csv'):
        self.path = db_folder  # перехват path.setter
        self.table_name = table_name  # перехват table.setter
        self.table = self.__init_table()

    @property
    def path(self) -> str:
        return self.__path

    @path.setter
    def path(self, path: str) -> None:
        full_path = os.path.join(PROJECT_ROOT, path)
        if path not in os.listdir(PROJECT_ROOT):
            os.mkdir(full_path)
        self.__path = full_path

    @property
    def table_name(self) -> str:
        return self.__table_name

    @table_name.setter
    def table_name(self, table_name: str) -> None:
        self.__table_name = table_name if table_name.endswith('.csv') else f'{table_name}.csv'

    @property
    def table(self) -> pandas.DataFrame:
        return self.__table

    @table.setter
    def table(self, table: pandas.DataFrame) -> None:
        self.__table = table

    def __get_path_to_table(self):
        return os.path.join(self.path, self.table_name)

    def __init_table(self) -> pandas.DataFrame:
        if self.table_name not in os.listdir(self.path):
            df = pandas.DataFrame(
                dict(
                    timestamp=pandas.Series(dtype='datetime64[ns]'),
                    uuid=pandas.Series(dtype='str'),
                    title=pandas.Series(dtype='str')
                )
            )
            df.to_csv(self.__get_path_to_table(), index=False)
        return pandas.read_csv(self.__get_path_to_table())

    def __save_table(self) -> None:
        self.table.to_csv(self.__get_path_to_table(), index=False)

    def __filter_table_content(self, column_name: str, eq_value) -> pandas.DataFrame:
        return self.table.loc[self.table[column_name] == eq_value]

    def __save_json_file(self, note: NoteFile) -> None:
        with open(os.path.join(self.path, f'{note.uuid}.json'), 'w', encoding=ENCODING) as file:
            note_dict = note.to_dict()
            # Объект типа datetime "is not JSON serializable"
            # (не сереализуется кастомным JSONEncoder)
            note_dict.pop('timestamp')
            json.dump(note_dict, file, ensure_ascii=False, indent=4)

    def __add_new_row(self, note: NoteFile) -> None:
        note_dict = note.to_dict()
        note_dict.pop('body')  # в *.csv таблицу пишем только: timestamp, uuid, title; body - удаляем
        new_row = pandas.Series(note_dict)
        self.table = pandas.concat([self.table, new_row.to_frame().T], ignore_index=True)
        self.__save_table()

    def __update_row(self, note: NoteFile) -> None:
        self.table.loc[self.table['uuid'] == note.uuid, 'title'] = note.title
        self.__save_table()

    def new_note(self, **kwargs) -> NoteFile:
        new_note = NoteFile(**kwargs)

        # UUID присваивается заметке в момент инициализации, контроль
        # уникальности UUID новой заметки реализуется в данном методе:
        while len(self.__filter_table_content('uuid', new_note.uuid)):
            new_note.generate_uuid()

        self.__save_json_file(new_note)
        self.__add_new_row(new_note)

        return self.open(new_note.uuid)

    def list_all(self) -> str:
        return self.table.to_string()

    def open(self, uuid) -> NoteFile | None:
        if len(self.__filter_table_content('uuid', uuid)):
            full_name = os.path.join(self.path, f'{uuid}.json')
            with open(full_name, 'r', encoding=ENCODING) as file:
                note = NoteFile(**json.load(file), timestamp=os.path.getctime(full_name))
            return note

    def update_note(self, note: NoteFile) -> None:
        self.__save_json_file(note)
        self.__update_row(note)

    def delete(self, uuid: str):
        pass
