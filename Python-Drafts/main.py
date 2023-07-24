from application import MainView, MainController, DataBase


def main():
    # Main loop:
    while MainController(DataBase(), MainView()).main_loop():
        pass


if __name__ == '__main__':
    main()
