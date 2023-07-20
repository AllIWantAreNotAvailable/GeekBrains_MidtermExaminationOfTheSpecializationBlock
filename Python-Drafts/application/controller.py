from . import ABC, Enum


class Controller(ABC):

    class EntityType(Enum):
        MASTER = 0
        SLAVE = 1

    def __init__(self, master, slave):
        self.__master = master
        self.__slave = slave

    def switch(self, entity_type: EntityType, new_entity):
        match entity_type:
            case Controller.EntityType.MASTER:
                self.__master = new_entity
            case Controller.EntityType.SLAVE:
                self.__slave = new_entity
            case _:
                # todo В ином случаем рассмотреть необходимость вызова исключения
                pass


class AppController(Controller):
    pass


class ViewController(Controller):
    pass


class DraftsController(Controller):
    """Реализовать консольное приложение заметки, с функциональностью:
        - сохранением заметок;
        - чтением заметок (при чтении списка заметок реализовать фильтрацию по дате);
        - добавлением заметок;
        - редактированием заметок;
        - удалением заметок.
    """
    pass
