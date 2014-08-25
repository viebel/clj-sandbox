(ns odaya
  [require [clojure.string :as string]])


(* 19999999999999999999999999999999999 19999999999999999999999999999)


(+ 2 3);2 +3
(+ 2 3 4 5); 2 + 3 + 4 + 5


(- 9 10)
(- 10 9)



(+ (+ 7 5) (* 3 4))


(let [koukou (+ 7 5)
      shoushou (* 3 4)]
  (+ koukou shoushou))





(apply + (map  toutou "abc"))



(defn guematria [name]
  (let [toutou {\a 1
                \b 2
                \c 3
                \d 4
                \e 5
                \f 6}]
    (apply + (map toutou name))))

(= (guematria "abca") 7)
(= (guematria "a") 1)
(= (guematria "abab") 6)


(count "odaya")
(count "advah")
(count "orel")
(count "neoray")
(count"yair")




