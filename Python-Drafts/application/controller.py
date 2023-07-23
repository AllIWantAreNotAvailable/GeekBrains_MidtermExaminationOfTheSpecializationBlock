from application import ABC, abstractmethod

from application import MainView, DataBase, NoteFile


class Controller(ABC):

    @abstractmethod
    def new_note(self) -> None:
        pass

    @abstractmethod
    def list_all(self) -> None:
        pass

    @abstractmethod
    def open(self) -> None:
        pass

    @abstractmethod
    def update_note(self) -> None:
        pass

    @abstractmethod
    def delete_note(self) -> None:
        pass


class MainController(Controller):

    def __init__(self, model: DataBase, view: MainView):
        self.model: DataBase = model
        self.view: MainView = view
        self.temp: NoteFile | None = None

    @property
    def model(self) -> DataBase:
        return self.__model

    @model.setter
    def model(self, model: DataBase) -> None:
        self.__model = model

    @property
    def view(self) -> MainView:
        return self.__view

    @view.setter
    def view(self, view: MainView) -> None:
        self.__view: MainView = view

    @property
    def temp(self) -> NoteFile:
        return self.__temp

    @temp.setter
    def temp(self, temp) -> None:
        self.__temp = temp

    def new_note(self) -> None:
        self.temp = self.model.new_note(**dict(title=self.view.input('Заголовок заметки:'),
                                               body=self.view.input('Содержание заметки:')))
        self.view.output(f'Заметка успешно создана!\n\n{str(self.temp)}')

    def list_all(self) -> None:
        notes_list = self.model.list_all()
        self.view.output(notes_list)

    def open(self) -> None:
        note_uuid = self.view.input('Введите uuid заметки:')
        self.temp = self.model.open(note_uuid)
        self.view.output(self.temp if self.temp else 'Заметка с таким uuid не найдена')

    def close(self):
        self.temp = None

    def update_note(self) -> None:

        def case(user_choice: str) -> bool:
            match user_choice.upper()[:1]:
                case 'Y':
                    return True
                case _:  # 'N' and others
                    return False

        if self.temp:
            choice = self.view.input('Изменить заголовок заметки? [Y - Yes / other - No]')
            if case(choice):
                self.temp.title = self.view.input('Заголовок заметки:')

            choice = self.view.input('Изменить содержание заметки? [Y - Yes / other - No]')
            if case(choice):
                self.temp.body = self.view.input('Содержание заметки:')

            self.model.update_note(self.temp)
            self.close()
        else:
            self.view.output('Заметка не загружена в память')

    def delete_note(self) -> None:
        if self.temp:
            self.model.delete(self.temp.uuid)
            self.close()
        else:
            self.view.output('Заметка не загружена в память')
