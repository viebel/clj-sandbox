(ns transducers
  (:use [clojure.core.async :only [<! go timeout chan >! put! <!!]]))


(def a (map #(* % 2)))


(transduce a + 0  (range 4))

(into [] a (range 4))


(def c (chan 1 a))

(def cc (chan 1 (comp
                 (filter #{37 39})
                 (map {37 :previous 39 :next}))))


(go
 (<! (timeout 5000))
 (println "done"))

(def d (chan))


(put! cc 37)
(go
 (println (<! cc)))



(put! c 19)

(go
 (println (<! c)))
