from abc import ABC, abstractmethod


class View(ABC):

    @staticmethod
    @abstractmethod
    def output(text_out: str):
        pass

    @staticmethod
    @abstractmethod
    def input(invitation: str):
        pass


class MainView(View):

    def __init__(self, controller):
        self.controller = controller

    @property
    def controller(self):
        return self.__controller

    @controller.setter
    def controller(self, controller):
        self.__controller = controller

    @staticmethod
    def output(text_out: str):
        print(text_out)

    @staticmethod
    def input(invitation: str):
        return input('\n'.join([invitation, '>>> ']))
