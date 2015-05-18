(ns my-macro
  (:require [clojure.template :as template]
            [clojure.walk :as walk]))




(defmacro def.me [name args f]
  `(defn ~name ~args (~f ~@args)))


(macroexpand '(def.me a [b c d] count))

(defmacro show-form [a] (meta &form))

(show-form (+ 1 2))



(defmacro show-env []
  (println (keys &env))
  (println (map namespace (keys &env))))


(let [band "zeppelin" city "london"]
  (show-env)
  (namespace 'band))


(:name :sadsad)



(defmacro log [x]
  (if (or (string? x) (and (coll? x) (= str (first x))))
    `(print ~x)
    `(print "merde")))


(macroexpand '(template/do-template [a b] (def a b) d 1 e 2 f 3))

(walk/macroexpand-all '(template/do-template [a b] (def a b) d 1 e 2 f 3))




(walk/macroexpand-all '(template/do-template [a b c] (= a b c) d 1 D e 2 D f 3 F))


(def klaas String)

(String. "dasds")



(klass. "dsdas")
