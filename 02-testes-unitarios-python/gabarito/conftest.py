# Coloca esta pasta no caminho de import, para os testes acharem o módulo ao lado.
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
