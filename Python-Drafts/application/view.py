from abc import ABC, abstractmethod


class BaseView(ABC):

    def __init__(self, controller):
        self.controller = controller

    @abstractmethod
    def controller(self):
        pass

