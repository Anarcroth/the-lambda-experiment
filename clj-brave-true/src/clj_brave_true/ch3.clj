(ns clj-brave-true.ch3)

;; A Clojure crash coures

;; 1. Use str, vector, list, hash-map, hash-set

;; String usage
(defn concat
  "Concatenate a thing to a constant string.
  Can be called like so: `(concat <MY_LITTLE_STRING>)`."
  [thing]
  (str "Look at this : " thing))

;; Vector usage
(defn get-first-element
  "Get the first element of a collection.
  Instead of using `first`, use `get`.
  Can be called like so: `(get-first-element [1 2 3 4])`."
  [col]
  (get col 0))

(defn set-at-index
  "Insert a number at a index point in a collection.
  Can be called like so: `(set-at-index [1 2 3 4] 0 5)`."
  [col indx val]
  (assoc col indx val))

(defn use-pop
  "Just a usage of `pop`.
  Can be called like so: `(use-pop [1 2 3 4])`."
  [col]
  (pop col))

(defn use-conj-vec
  "Just a usage of `conj` on vector.
  Can be called like so: `(use-conj-vec [1 2 3 4])`."
  [col]
  (map conj [col] col))

(defn use-cons
  "Just a usage of `cons`.
  Can be called like so: `(use-cons [1 2 3 4])`."
  [col]
  (map cons col [col]))

;; List usage

(defn get-nth
  "Just a usage of `nth`.
   Can be called like so: `(get-nth '(1 2 3 4) 3)`."
  [col n]
  (nth col n))

(defn use-conj-list
  "Just a usage of `conj` on list.
  Can be called like so: `(use-conj-vec '(1 2 3 4) 5)`."
  [col el]
  (conj col el))

(defn is-list
  "Just a usage of `list?`.
  Can be called like so: `(is-list '(1 2 3 4))`."
  [col]
  (list? col))

;; Usage hash-map

(defn get-from-map
  "Just a usage of `get` for map.
  Can be called like so: `(get-from-map {:a 1 :b 2} :a)`."
  [m k]
  (k m)
  ;; or more verbosely written
  ;;(get m k)
  )

(defn get-with-default
  "Just a usage of `get` with default value.
  Can be called like so: `(get-with-default {:a 1} :b)`."
  [m k]
  (get m k "default-val"))

(defn get-from-nested-map
  "Just a usage of `get` with nested map.
  Can be called like so: `(get-with-default {:a 1 {:b 2}} :a :b)`."
  [m k1 k2]
  (get m [k1 k2]))

(defn create-string-value-map
  "Create a map between a single value and each character of a string.
  Can be called like so: `(create-string-value-map <YOUR_STRING> <YOUR_NUM>)`."
  [string value]
  (map #(hash-map % value) (seq string)))

;; Usage hash-set

(defn create-set
  "Just a usage of `hash-set`.
  Can be called like so: `(create-set 1 1 2 3 4 4 5 5)`."
  [col]
  (hash-set col))

(defn use-conj-set
  "Just a usage of `conj` on set.
  Can be called like so: `(use-conj-set #{1 2 3 4} 5)`."
  [col k]
  (conj col k))

(defn use-contains
  "Just a usage of `contains?`.
  Can be called like so: `(use-contains #{1 2 3 4} 2)`."
  [col k]
  (contains? col k))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn add-100
  "Add 100 to any given number."
  [n]
  (+ n 100))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn dec-maker
  "Decrement by a given amount each time when called."
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn mapset
  "Create a set from a mapping."
  [f col]
  (set (map f col)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Create a function that’s similar to symmetrize-body-parts except that it
;; has to work with weird space aliens with radial symmetry. Instead of
;; two eyes, arms, legs, and so on, they have five.

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

;; Simple solution
(defn matching-part
  [part]
  [{:name (clojure.string/replace (:name part) #"^left-" "right-")
    :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^left-" "LR-")
    :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^left-" "RL-")
   :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^left-" "middle-")
    :size (:size part)}])

(defn symmetrize-body-parts
    "Expects a seq of maps that have a :name and :size"
    [asym-body-parts]
    (loop [remaining-asym-parts asym-body-parts
           final-body-parts []]
      (if (empty? remaining-asym-parts)
        final-body-parts
        (let [[head & tail] remaining-asym-parts]
          (print head (matching-part head))
          (recur tail
                 (into final-body-parts
                       (set (matching-part head))))))))
