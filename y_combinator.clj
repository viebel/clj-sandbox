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
  (fn fac [x]
    (if (= 0 x)
      1
      (* x (f (dec x))))))


; (make-fac (Y make-fac)) == (Y make-fac)
; (make-fac fac) == fac
; => (Y make-fac) == fac

((Y make-fac) 5)



