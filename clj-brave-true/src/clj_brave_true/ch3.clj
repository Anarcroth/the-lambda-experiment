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

(defn use-conj-vec
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
