from application.view import MainView
from application.controller import MainController
from application.model import DataBase


def main():
    controller = MainController(DataBase(), MainView())
    controller.list_all()
    # controller.update_note()
    # controller.open()


def test_fill():
    db = DataBase()
    for i in range(100):
        db.new_note(**dict(title=f'Title of test note №{i}',
                           body=f'Content of test note №{i}'))


if __name__ == '__main__':
    # test_fill()
    main()
