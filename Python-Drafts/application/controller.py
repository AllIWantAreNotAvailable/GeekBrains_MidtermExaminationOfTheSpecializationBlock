from application import ABC, abstractmethod

from application import MainView


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

    def __init__(self, model, view: MainView):
        self.model = model
        self.view: MainView = view
        self.temp: str = ''

    @property
    def model(self):
        return self.__model

    @model.setter
    def model(self, model) -> None:
        self.__model = model

    @property
    def view(self) -> MainView:
        return self.__view

    @view.setter
    def view(self, view: MainView) -> None:
        self.__view: MainView = view

    @property
    def temp(self) -> str:
        return self.__temp

    @temp.setter
    def temp(self, temp) -> None:
        self.__temp = temp

    def new_note(self) -> None:
        new_note = dict(title=self.view.input('Заголовок заметки:'),
                        body=self.view.input('Содержание заметки:'))

    def list_all(self) -> None:
        notes_list = list()
        self.view.output(notes_list)

    def open(self) -> None:
        note_uuid = self.view.input('Введите uuid заметки:')

    def update_note(self) -> None:

        def case(user_choice: str) -> bool:
            match user_choice.upper():
                case 'Y':
                    return True
                case _:  # 'N' and others
                    return False

        note_uuid = self.view.input('Введите uuid заметки:')
        note = None  # Имеющаяся заметка
        choice = self.view.input('Изменить заголовок заметки? [Y/N]')
        if case(choice):
            note.title = self.view.input('Заголовок заметки:')

        choice = self.view.input('Изменить содержание заметки? [Y/N]')
        if case(choice):
            note.body = self.view.input('Содержание заметки:')

        # Сохранить заметку

    def delete_note(self) -> None:
        note_uuid = self.view.input('Введите uuid заметки:')
