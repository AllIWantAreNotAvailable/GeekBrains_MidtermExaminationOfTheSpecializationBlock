from application import MainView

from application.model import NotesFileDataBase


class Controller:

    def __init__(self, view):
        self.view: MainView = view
        self.database: NotesFileDataBase = NotesFileDataBase()

    @property
    def view(self):
        return self.__view

    @view.setter
    def view(self, view):
        self.__view = view

    @property
    def database(self):
        return self.__database

    @database.setter
    def database(self, database: NotesFileDataBase):
        self.__database = database

    def create(self):
        note = dict(title=self.view.input('\nУкажите заголовок заметки:'),
                    body=self.view.input('\nВведите содержание заметки:'))
        self.database.create(note)

    def read(self):
        sorted_notes = sorted(self.database.read(), key=lambda note: note.timestamp)
        self.view.output(*sorted_notes, sep='\n\n')

    def update(self):
        pass

    def delete(self):
        pass


if __name__ == '__main__':
    controller = Controller(MainView)
    controller.read()
