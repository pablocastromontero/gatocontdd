(ns tddProject.core)

(def secuencias-ganadoras [[0 1 2] [3 4 5] [6 7 8] [0 3 6] [1 4 7] [2 5 8] [0 4 8] [2 4 6]])

(defn crear-tablero []
    (vec (to-array (repeat 9 " ")))
  )

(defn tablero-lleno? [tablero]
  (not (some #(= " " %) tablero))
  )

(defn casilla-vacia? [tablero posicion]
    (= " " (nth tablero posicion))
  )

(defn movimiento-jugador [tablero posicion marca]
  (if (casilla-vacia? tablero posicion)
      (assoc tablero posicion marca)
      nil
    )
  )

(defn movimiento-computadora [tablero marca]
  (let [posicion (rand-int 9)]
       (if (casilla-vacia? tablero posicion)
           (assoc tablero posicion marca)
           (recur tablero marca)
         )
    )
  )

(defn ganador-en-secuencia? [tablero secuencia]
    (apply = (map #(nth tablero %) secuencia))
  )

(defn primera-posicion-secuencia [secuencias]
    (first (first secuencias))
  )

(defn obtener-contenido-posicion-tablero [tablero posicion]
  (nth tablero posicion )
  )

(defn no-es-secuencia-vacia [tablero secuencias]
    (not= " " (obtener-contenido-posicion-tablero tablero (primera-posicion-secuencia secuencias)))
  )

(defn ganador? [tablero]
    (loop [secuencias secuencias-ganadoras]
        (cond
            (empty? secuencias)
              false
            (and (ganador-en-secuencia? tablero (first secuencias)) (no-es-secuencia-vacia tablero secuencias) )
               (obtener-contenido-posicion-tablero tablero (primera-posicion-secuencia secuencias) )
            :else
                (recur (rest secuencias))
          )
      )

  )


(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
