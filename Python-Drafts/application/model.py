# Dependencies
from application import ABC, abstractmethod

# file system operations
from application import os, sys

DB_NAME = 'drafts'
DB_FOLDER = os.path.join(os.path.curdir, DB_NAME)


class DataBase(ABC):
    """Реализовать консольное приложение заметки, с функциональностью:
            - сохранением заметок;
            - чтением заметок (при чтении списка заметок реализовать фильтрацию по дате);
            - добавлением заметок;
            - редактированием заметок;
            - удалением заметок.
    """

    @abstractmethod
    def create(self):
        pass

    @abstractmethod
    def read(self):
        pass

    @abstractmethod
    def update(self):
        pass

    @abstractmethod
    def delete(self):
        pass


class FileDataBase(DataBase):

    def __init__(self):
        self.__path = DB_FOLDER
        self.temp_file = None
        self.temp_list = None

    @property
    def path(self):
        return self.__path

    def create(self):
        pass

    def read(self):
        pass

    def update(self):
        pass

    def delete(self):
        pass


class Note(ABC):
    """Заметка должна содержать:
        - идентификатор заметки;
        - заголовок заметки;
        - тело заметки;
        - дату/время создания или последнего изменения заметки.
    """

    def __init__(self, title: str, body: str) -> None:
        self.title = title
        self.body = body


class SimpleNote(Note):

    def __init__(self, title: str, body: str) -> None:
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
        return '\n'.join([self.title, self.body])
