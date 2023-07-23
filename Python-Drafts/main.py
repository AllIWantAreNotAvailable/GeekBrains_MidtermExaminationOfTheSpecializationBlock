from application.model import DataBase, new_uuid, datetime, os, PATH_TO_DATABASE, DATABASE_NAME, pandas


def main():
    db = DataBase()
    db.table.to_csv(os.path.join(PATH_TO_DATABASE, DATABASE_NAME, 'db.csv'), index=False)


if __name__ == '__main__':
    main()
