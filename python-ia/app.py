from fastapi import FastAPI
from pydantic import BaseModel
import joblib

#cargamos el modelo
modelo=joblib.load("modelo_emociones.pkl")
app=FastAPI()

class Texto(BaseModel):
    comentario:str

@app.post("/predict")
def predict(data: Texto):
    prediccion=modelo.predict([data.comentario])[0]
    return{
        "emocion":prediccion
    }

