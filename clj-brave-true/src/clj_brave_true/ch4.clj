(ns clj-brave-true.ch4)

;;;;;;;;;;;;;;;;;;;;
;; Task 1
;;;;;;;;;;;;;;;;;;;;

(def names '(["Edward Cullen" "10"], ["Bella Swan" "0"], ["Charlie Swan" "0"],
                                     ["Jacob Black" "3"], ["Carlisle Cullen" "6"]))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn mapify
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  "Return a list of names that pass the glitter-filter"
  [minimum-glitter records]
  (map #(:name %)
       (filter (fn [vamp]
                 (if (>= (:glitter-index vamp) minimum-glitter)
                   (:name vamp)))
               records)))

;;;;;;;;;;;;;;;;;;;;
;; Task 2
;;;;;;;;;;;;;;;;;;;;

(defn append-suspect
  "Appends a suspect to the list"
  [name glitter-index]
  (conj names [(str name) (str glitter-index)]))

;;;;;;;;;;;;;;;;;;;;
;; Task 3
;;;;;;;;;;;;;;;;;;;;

(defn has-name?
  [n]
  (true? n))

(defn has-glitter?
  [n]
  (> n -1))

(def valid-suspect {:name has-name?
                    :glitter-index has-glitter?})

(defn is-valid-suspect?
  [m k v]
  ((get m k) v))

(defn validate
  [keywords record]
  (if (and
       (is-valid-suspect? valid-suspect :name (:name record))
       (is-valid-suspect? valid-suspect :glitter-index (:glitter-index record)))))
