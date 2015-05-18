(ns match-me
  (use  [clojure.core.async :only [<! go timeout chan >! put! <!!]]
        [clojure.core.match :only (match)]))




(let [x [1 2 nil nil nil]]
  (match [x]
    [([1 2 nil nil nil] :seq)] :bbbb
    [([1] :seq)] :a0
    [([1 2] :seq)] :a1
    [([1 2 nil nil nil] :seq)] :a2
    :else nil))

(true? 1)

(let [x "aa" #_{:a 1 :b 1}]
  (match x
    "aab" 19
    (zz :guard string?) zz
    {:a _ :b 2} :a0
    :else nil))

(keyword "aaa" "bb")

(string? "aaa")

(not (nil? nil))



(match (rand-nth [[:status {}] :error {:wm :aa}])
       [status data] data
       :error :err
       :else :boox)


(def c (chan))

(put! c :loaded)

(go
 (println "read: "
          (match (<! c)
                 [status data] data
                 :loaded :loaded
                 :else :boox)))



(defn foo[]
  (let [a (fn [] "a")]
    (a)))





(def aaa 5)










(var aaa)
(meta (var aaa))