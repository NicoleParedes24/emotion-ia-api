import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.pipeline import Pipeline
import joblib

#cargamos en dataset
df=pd.read_csv("dataset.csv")

x=df["texto"]
y=df["emocion"]

modelo=Pipeline([
    ("tfidf",TfidfVectorizer()),
    ("clf",LogisticRegression())
])

modelo.fit(x,y)
#guardamos el modelo
joblib.dump(modelo,"modelo_emociones.pkl")
print("Modelo Entrenado")