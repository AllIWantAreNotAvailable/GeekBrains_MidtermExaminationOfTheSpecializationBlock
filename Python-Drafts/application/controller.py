from application import ABC, abstractmethod

from application import Enum


class MenuStatus(Enum):
    EXIT = 0
    PREV = 1
    CONT = 2
    NEXT = 3


class Controller(ABC):

    @abstractmethod
    def new_note(self) -> ...:
        ...

    @abstractmethod
    def list_all(self) -> ...:
        ...

    @abstractmethod
    def open(self) -> ...:
        ...

    @abstractmethod
    def update_note(self) -> ...:
        ...

    @abstractmethod
    def delete_note(self) -> ...:
        ...


class MainController(Controller):

    def __init__(self, model, view):
        self.model = model
        self.view = view
        self.cur_menu = self.__main_menu
        self.temp = None

    @property
    def model(self):
        return self.__model

    @model.setter
    def model(self, model) -> None:
        self.__model = model

    @property
    def view(self):
        return self.__view

    @view.setter
    def view(self, view) -> None:
        self.__view = view

    @property
    def temp(self):
        return self.__temp

    @temp.setter
    def temp(self, temp) -> None:
        self.__temp = temp

    @property
    def cur_menu(self):
        return self.__cur_menu

    @cur_menu.setter
    def cur_menu(self, menu) -> None:
        self.__cur_menu = menu

    def main_loop(self) -> bool:
        return self.cur_menu()

    def __main_menu(self) -> bool:
        main_menu = {'1. Вывести все заметки': (self.list_all, MenuStatus.CONT),
                     '2. Создать заметку': (self.new_note, MenuStatus.NEXT),
                     '3. Открыть заметку': (self.open, MenuStatus.NEXT),
                     '4. Закрыть': (self.close, MenuStatus.EXIT)}
        sorted_keys = sorted(list(main_menu.keys()))
        temp_dict = {str(e): v for e, v in enumerate(sorted_keys, 1)}
        self.view.output(*[f'{e}. {v[3:]}' for e, v in enumerate(sorted_keys, 1)], sep='\n')
        choice = self.view.input('Укажите номер команды:')
        method, status = main_menu[temp_dict[choice]]

        method()

        match status:
            case MenuStatus.CONT:
                return True
            case MenuStatus.NEXT:
                self.cur_menu = self.__file_menu
                return True
            case MenuStatus.EXIT:
                return False
            case _:
                return False

    def __file_menu(self) -> bool:
        file_menu = {'Удалить': (self.delete_note, MenuStatus.PREV),
                     'Редактировать': (self.update_note, MenuStatus.CONT),
                     'Закрыть': (self.close, MenuStatus.PREV)}
        sorted_keys = sorted(list(file_menu.keys()))
        temp_dict = {str(e): v for e, v in enumerate(sorted_keys, 1)}
        self.view.output(*[f'{e}. {v}' for e, v in enumerate(sorted_keys, 1)], sep='\n')
        choice = self.view.input('Укажите номер команды:')
        method, status = file_menu[temp_dict[choice]]

        method()

        match status:
            case MenuStatus.PREV:
                self.cur_menu = self.__main_menu
                return True
            case MenuStatus.CONT:
                return True
            case _:
                return False

    def new_note(self) -> None:
        self.temp = self.model.new_note(**dict(title=self.view.input('Заголовок заметки:'),
                                               body=self.view.input('Содержание заметки:')))
        self.view.output(f'Заметка успешно создана.', str(self.temp), sep='\n\n')

    def list_all(self) -> None:
        notes_list = self.model.list_all()
        self.view.output(notes_list.to_string() if len(notes_list) else 'Заметки не найдены.')

    def open(self) -> None:
        note_uuid = self.view.input('Введите uuid заметки:')
        self.temp = self.model.open(note_uuid)
        self.view.output(self.temp if self.temp else 'Заметка с таким uuid не найдена.')

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
            self.view.output(f'Заметка успешно изменена.', str(self.temp), sep='\n\n')
        else:
            self.view.output('Заметка не загружена в память.')

    def delete_note(self) -> None:
        if self.temp:
            self.model.delete(self.temp.uuid)
            self.view.output('Заметка была успешно удалена.')
        else:
            self.view.output('Заметка не загружена в память.')
