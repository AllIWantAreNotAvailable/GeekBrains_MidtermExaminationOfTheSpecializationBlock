from application import MainView, MainController, DataBase


def main():
    # Main loop:
    controller = MainController(DataBase(), MainView())
    while controller.main_loop():
        pass


if __name__ == '__main__':
    main()
