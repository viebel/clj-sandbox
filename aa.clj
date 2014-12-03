(ns user
  (:use
   [clojure.core.async :only [<! go timeout chan >!]]))




(def a 4)
(defmacro me []
  `(+ v 2))


(macroexpand-1 '(me))


(me)






(defmacro deftry [& definition]
  (if (vector? (second definition))
    (let [[name args & body] definition]
    `(defn ~name ~args
       (try ~@body
         (catch Error e#
           (println "error caught:" e#)))))
    (let [[name & definitions] definition]
      `(defn ~name ~@(map (fn [[args body]] `(~args (try ~@body (catch Error e# (println "err caught")))))
                                          definitions)))))




(defmacro deftry [& definition]
  (if (vector? (second definition))
    (let [[name args & body] definition]
    `(defn ~name ~args
       (try ~@body
         (catch Error e#
           (println "error caught:" e#)))))
    `(defn foofo [] 5)))



(macroexpand-1 '(deftry foob [a] 3))

(deftry foob [a] 3)


(foob 1)


(deftry fooa
    ([a] 3)
    ([] 5))


(foofo)



(def definition '([a] 3)
    ([] 5))
(let [[name & definitions] definition]
      `(defn ~name ~@(map (fn [[args body]] `(~args (try ~@body (catch Error e# (println "err caught")))))
                                          definitions)))
