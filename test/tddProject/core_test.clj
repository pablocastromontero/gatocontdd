(ns tddProject.core-test
  (:use clojure.test
        tddProject.core))

(deftest test-crear-tablero
  (testing "Crear tablero inicial"
    (is (= (crear-tablero) [" " " " " " " " " " " " " " " " " "]))))

(deftest test-tablero-lleno
  (testing "Está el lleno el tablero"
    (is (= (tablero-lleno? ["X" "O" "X" "O" "X" "O" "X" "O" "X"]) true ))
    )
  )

(deftest test-tablero-lleno2
  (testing "No está el lleno el tablero"
    (is (= (tablero-lleno? (crear-tablero )) false ))
    )
  )

(deftest test-movimiento-jugador
  (testing "Jugador hace movimiento correcto"
    (is (not (= (movimiento-jugador (crear-tablero) 1 "X") (crear-tablero))))
    )
  )

(deftest test-movimiento-computadora
  (testing "Computador hace movimiento correcto"
    (is (not (= (movimiento-computadora ["X" "O" "X" "O" "X" "O" "X" " " "X"] "O") ["X" "O" "X" "O" "X" "O" "X" " " "X"]))
      )
    )
  )

(deftest test-movimiento-computadora2
  (testing "Computador hace movimiento correcto"
    (is (not (= (movimiento-computadora (crear-tablero ) "O") (crear-tablero)))
      )
    )
  )

(deftest test1-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? ["X" "X" "X" " " " " " " " " " " " "]) "X"))
    )
  )

(deftest test2-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? [" " " " " " "X" "X" "X" " " " " " "]) "X"))
      )
    )

(deftest test3-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? [" " " " " " " " " " " " "X" "X" "X"]) "X"))
    )
  )


(deftest test4-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? ["O" " " " " "O" " " " " "O" " " " "]) "O"))
    )
  )

(deftest test5-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? [" " "O" " " " " "O" " " " " "O" " "]) "O"))
    )
  )

(deftest test6-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? [" " " " "O" " " " " "O" " " " " "O"]) "O"))
    )
  )

(deftest test7-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? ["O" " " " " " " "O" " " " " " " "O"]) "O"))
    )
  )

(deftest test8-ganador?
  (testing "Algún jugaodr ha ganado?"
    (is (= (ganador? [" " " " "O" " " "O" " " "O" " " " "]) "O"))
    )
  )

(deftest test-humanovshumanogana1
  (testing "humano vs humano gana 1"
      (is  (= (ganador? ["1" "0" "1" "1" "O" "1" "1" "0" " "]) "1")
      )
    )
  )

(deftest test-humanovshumanoempate
  (testing "humano vs humano empate"
    (is  (= (ganador? ["1" "0" "1" "1" "O" "1" "0" "1" "0"]) false)
      )
    )
  )