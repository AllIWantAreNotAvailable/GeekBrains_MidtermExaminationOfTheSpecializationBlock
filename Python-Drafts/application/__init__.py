# Dependencies
from abc import ABC, abstractmethod, abstractstaticmethod
from enum import Enum

# System
import os
import sys

# "Сохранение заметок необходимо сделать в формате json или csv формат" – выбран формат *.json
from json import dumps as serialize
from json import loads as deserialize
