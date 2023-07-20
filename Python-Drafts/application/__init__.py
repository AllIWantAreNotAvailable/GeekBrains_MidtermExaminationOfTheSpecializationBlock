# Dependencies
from abc import ABC, abstractmethod
from enum import Enum

# "Сохранение заметок необходимо сделать в формате json или csv формат" – выбран формат *.json
from json import dumps as serialize
from json import loads as deserialize
