from application import ABC, abstractmethod


class View(ABC):

    @staticmethod
    @abstractmethod
    def output(*args, **kwargs) -> None:
        pass

    @staticmethod
    @abstractmethod
    def input(introduction: str) -> str:
        pass


class MainView(View):

    @staticmethod
    def output(*args, **kwargs) -> None:
        print()
        print(*args, **kwargs)

    @staticmethod
    def input(introduction: str) -> str:
        decorator = '\n>>> '
        return input(f'\n{introduction}{decorator}' if introduction else decorator)
