(ns user
  (:require [clojure.string :as string])
  (:use
   [clojure.core.async :only [<! go timeout chan >!]]))

(defn to-num [x]
  (read-string (string/replace x #"ms" "")))

(to-num "0.046ms")


(def data (string/split (slurp "/tmp/ff") #"\n"))

(map second (map #(string/split % #":") data))


(reduce (fn [res [k t]]
          #_(println t)
          (assoc res k [(+ (first (get res k [0 0])) (to-num t))
                        (inc (second (get res k [0 0])))]))
        {}
        (map #(string/split % #":") data))
