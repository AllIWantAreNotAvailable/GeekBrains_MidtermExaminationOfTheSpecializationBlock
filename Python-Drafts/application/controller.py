from application import MainView, NotesFileDataBase


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

    def get_sorted_notes_list(self, file_id: str = '', sort_func=None, reverse: bool = False):
        return sorted(self.database.read(file_id),
                      key=sort_func if sort_func else lambda note: note.timestamp,
                      reverse=reverse)

    def create(self):
        note = dict(title=self.view.input('\nУкажите заголовок заметки:'),
                    body=self.view.input('\nВведите содержание заметки:'))
        self.database.create(note)

    def read(self):
        notes_list = self.get_sorted_notes_list()

        if len(notes_list) == 1:
            note_file = notes_list[0]
            self.view.output('\n'.join([str(note_file), note_file.get_content()]))
            return

        self.view.output(*notes_list, sep='\n\n')

    def update(self):
        pass

    def delete(self):
        pass


if __name__ == '__main__':
    controller = Controller(MainView)
    controller.read()
