from abc import ABC, abstractmethod
from enum import Enum


class Commands(Enum):
    CREATE = 0
    READ = 1
    UPDATE = 2
    DELETE = 3


class Controller(ABC):

    def __init__(self, view):
        self.view = view

    @abstractmethod
    def view(self):
        pass

