# STANDARD LIBRARY:
from abc import ABC, abstractmethod
from uuid import uuid4 as new_uuid
from datetime import datetime

import os
import sys
import json

# DEPENDENCIES:
import pandas

# FINAL APP:
from application.view import MainView
from application.model import DataBase, NoteFile
