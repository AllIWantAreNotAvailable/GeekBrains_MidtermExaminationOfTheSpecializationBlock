from application import ABC, abstractmethod
from application import new_uuid, datetime
from application import os

from application import pandas

ENCODING = 'UTF-8'

PATH_TO_DATABASE = os.path.join(os.curdir)
DATABASE_NAME = 'notes'


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
                 timestamp: datetime = None) -> None:
        self.title: str = title
        self.body: str = body
        self.uuid: str = uuid if uuid else new_uuid()
        self.timestamp: datetime = datetime if timestamp else datetime.now()

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
    def uuid(self) -> str:
        return self.__uuid

    @uuid.setter
    def uuid(self, uuid: str) -> None:
        self.__uuid = uuid

    @property
    def timestamp(self) -> datetime:
        return self.__timestamp

    @timestamp.setter
    def timestamp(self, timestamp: datetime) -> None:
        self.__timestamp = timestamp


class DataBase:

    def __init__(self, database_name: str = DATABASE_NAME, table_name: str = 'db.csv'):
        self.path: bytes = database_name  # перехват path.setter
        self.table_name: str = table_name  # перехват table.setter
        self.table: pandas.DataFrame

    @property
    def path(self) -> str:
        return self.__path

    @path.setter
    def path(self, path: str) -> None:
        full_path = os.path.join(PATH_TO_DATABASE, path)
        if path not in os.listdir(PATH_TO_DATABASE):
            os.mkdir(full_path)
        self.__path = full_path

    @property
    def table_name(self) -> str:
        return self.__table_name

    @table_name.setter
    def table_name(self, table_name: str) -> None:
        self.__table_name = '.csv' if not table_name.endswith('.csv') else ''

    @property
    def table(self) -> pandas.DataFrame:
        return self.__table

    @table.setter
    def table(self, table: pandas.DataFrame) -> None:
        path_to_table = os.path.join(self.path, self.table_name)
        if self.table_name not in os.listdir(self.path):
            df = pandas.DataFrame(
                dict(
                    UUID=pandas.Series(dtype='str'),
                    TIMESTAMP=pandas.Series(dtype='datetime64[ns]'),
                    TITLE=pandas.Series(dtype='str')
                )
            )
            df.to_csv(path_to_table, index=False)

        self.__table: pandas.DataFrame = pandas.read_csv(path_to_table)
