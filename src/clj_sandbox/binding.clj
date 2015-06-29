(ns clj-sandbox.binding)


(defn get-count [s]
  (count s))


(get-count (range 10))


(with-redefs-fn {#'clojure.core/count (constantly 3)}
  #(get-count (range 10)))


(meta 'count)
