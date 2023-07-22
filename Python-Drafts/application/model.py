import os
import uuid
import json
from datetime import datetime

ENCODING = 'UTF-8'
DATABASE_FOLDER = 'notes'
DATABASE_PATH = os.path.join(os.curdir)  # todo Добавить в путь DATABASE_FOLDER после отладки


class Note:
    def __init__(self, title: str = 'No title', body: str = 'Empty note') -> None:
        self.title = title
        self.body = body

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

    def __str__(self) -> str:
        return '\n'.join([f'Заголовок: {self.title}',
                          f'Содержание: {self.body}'])


class NoteFile(Note):

    def __init__(self, file_name: str, timestamp: datetime, title: str = 'No title', body: str = 'Empty note') -> None:
        super().__init__(title, body)
        self.file_name = file_name
        self.timestamp = timestamp

    @property
    def file_name(self) -> str:
        return self.__file_name

    @file_name.setter
    def file_name(self, file_name) -> None:
        self.__file_name = file_name

    def get_content(self) -> str:
        return super().body

    def __str__(self) -> str:
        return '\n'.join([f'Дата создания (редактирования): {self.timestamp.replace(microsecond=0)}',
                          f'UUID: {self.file_name}',
                          f'Заголовок: {super().title}'])


class UUID:

    def __init__(self, dir_path: str, count: int = 10):
        self.count = count
        self.dir_path = dir_path
        self.__uuids = self.__fill_uuids(self.dir_path)

    @property
    def count(self) -> int:
        return self.__count

    @count.setter
    def count(self, count: int) -> None:
        self.__count = count

    @property
    def dir_path(self) -> str:
        return self.__dir_path

    @dir_path.setter
    def dir_path(self, dir_path: str) -> None:
        self.__dir_path = dir_path

    @staticmethod
    def file_checker():
        return lambda path, file_name: os.path.isfile(os.path.join(path, file_name)) and not file_name.startswith('.')

    @staticmethod
    def __is_not_used(dir_path: str, file_name: str) -> bool:
        return file_name not in {file.split('.')[0] for file in os.listdir(dir_path)
                                 if UUID.file_checker()(dir_path, file)}

    def __fill_uuids(self, dir_path: str) -> set[str]:
        new_uuids: set[str] = set()
        while len(new_uuids) < self.count:
            new_uuid = str(uuid.uuid4())
            if self.__is_not_used(dir_path, new_uuid):
                new_uuids.add(new_uuid)
        return new_uuids

    def __call__(self, *args, **kwargs) -> str:
        try:
            return self.__uuids.pop()
        except KeyError:
            self.__uuids = self.__fill_uuids(self.dir_path)
            self.__call__()


class NotesFileDataBase:

    def __init__(self):
        self.path = DATABASE_PATH
        self.uuid_generator = UUID(self.path)

    def create(self, note: dict[str, str]) -> None:
        with open(os.path.join(self.path, f'{self.uuid_generator()}.json'), 'w', encoding=ENCODING) as file:
            json.dump(note, file, ensure_ascii=False)

    def read(self, file_id: str = '') -> list[NoteFile]:
        notes = list()
        if file_id:
            pass
        else:
            for file_name in os.listdir(self.path):
                if self.uuid_generator.file_checker()(self.path, file_name):

                    if file_name.split('.')[1] != 'json':
                        continue

                    path_to_file = os.path.join(self.path, file_name)
                    ctime = os.path.getctime(path_to_file)
                    timestamp = datetime.fromtimestamp(ctime)
                    file_name_without_extension = file_name.split('.')[0]

                    with open(path_to_file, 'r', encoding=ENCODING) as file:
                        notes.append(NoteFile(file_name_without_extension, timestamp, **json.load(file)))

        return notes

    def update(self) -> None:
        pass

    def delete(self, file_name: str) -> None:
        pass
