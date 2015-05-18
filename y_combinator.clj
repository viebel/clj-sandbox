(ns y-combinator)

;http://www.viksit.com/tags/clojure/practical-applications-y-combinator-clojure/

;; Y combinator
(defn Y [m] ;;  λf
  ((fn [future] ;; λx
     (future future)) ;; f(x x)
   (fn [future] ;; λx
     (m (fn [arg]
          ((future future) arg)))))) ;; f(x x)



(defn make-fac [f]
  (fn [x]
    (if (= 0 x)
      1
      (* x (f (dec x))))))


; (make-fac (Y make-fac)) == (Y make-fac)
; (make-fac fac) == fac where fac is the usual factorial function
; => (Y make-fac) == fac

((Y make-fac) 5)

(defn make-fib [f]
  (fn [x]
    (if (<= x 1)
      1
      (+ (f (- x 2))
       (f (dec x))))))

(time
((Y make-fib) 10))


(defn make-memo-fib [f]
  (memoize (fn [x]
             (println x)
             (if (<= x 1)
               1
               (+ (f (- x 2))
                  (f (dec x)))))))

(time
((Y make-memo-fib) 4))






