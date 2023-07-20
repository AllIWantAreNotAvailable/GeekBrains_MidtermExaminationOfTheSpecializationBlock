# Dependencies
from application import ABC, abstractmethod
from application import uuid4
from application import serialize, deserialize

# file system operations
from application import os, sys

DB_NAME = 'drafts'
DB_FOLDER = os.path.join(os.path.curdir, DB_NAME)
ENCODING = 'UTF-8'


class Note(ABC):
    """Заметка должна содержать:
        - идентификатор заметки;
        - заголовок заметки;
        - тело заметки;
        - дату/время создания или последнего изменения заметки.
    """

    def __init__(self, title: str = 'No title', body: str = 'Empty note') -> None:
        self.title = title
        self.body = body


class SimpleNote(Note):

    def __init__(self, title: str = 'No title', body: str = 'Empty note') -> None:
        super().__init__(title, body)

    @property
    def title(self):
        return self.__title

    @title.setter
    def title(self, title: str):
        self.__title = title

    @property
    def body(self):
        return self.__body

    @body.setter
    def body(self, body: str):
        self.__body = body

    def __str__(self):
        return '\n'.join([f'title: {self.title}', f'body: {self.body}'])


class NoteFile(SimpleNote):

    def __init__(self, uuid, title: str = 'No title', body: str = 'Empty note', datetime=''):
        super().__init__(title, body)
        self.uuid = uuid
        self.datetime = datetime

    def get_note(self):
        return super().__dict__

    @property
    def uuid(self):
        return self.__uuid

    @uuid.setter
    def uuid(self, uuid):
        self.__uuid = uuid

    @property
    def datetime(self):
        return self.__datetime

    @datetime.setter
    def datetime(self, datetime):
        self.__datetime = datetime

    def __str__(self):
        return '\n'.join([f'last changes: {self.datetime}', f'UUID: {self.uuid}', str(super)])


class DataBase(ABC):
    """Реализовать консольное приложение заметки, с функциональностью:
            - сохранением заметок;
            - чтением заметок (при чтении списка заметок реализовать фильтрацию по дате);
            - добавлением заметок;
            - редактированием заметок;
            - удалением заметок.
    """

    @abstractmethod
    def is_new_id(self, uuid):
        pass

    @abstractmethod
    def get_uuid(self):
        pass

    @abstractmethod
    def create(self, note: SimpleNote):
        pass

    @abstractmethod
    def read(self, uuid: str = ''):
        pass

    @abstractmethod
    def update(self, uuid: str, note: SimpleNote):
        pass

    @abstractmethod
    def delete(self, uuid: str):
        pass


class FileDataBase(DataBase):

    def __init__(self):
        self.__path = DB_FOLDER

    @property
    def path(self):
        return self.__path

    def is_new_id(self, uuid):
        return uuid not in map(lambda full_name: full_name.split('.')[0], os.listdir(self.path))

    def __generate_uuid(self):
        while True:
            uuid = uuid4()
            if self.is_new_id(uuid):
                return uuid

    def get_uuid(self):
        return self.__generate_uuid()

    def __save_to_file(self, note_file: NoteFile):
        file_name = '.'.join([note_file.uuid, 'json'])
        with open(os.path.join(self.path, file_name), 'w', encoding=ENCODING) as file:
            file.write(serialize(note_file.get_note()))

    def create(self, note: SimpleNote):
        new_note = NoteFile(self.get_uuid(), **note.__dict__)
        self.__save_to_file(new_note)

    def read(self, uuid: str = ''):
        pass

    def update(self, uuid: str, note: SimpleNote):
        pass

    def delete(self, uuid: str):
        pass
