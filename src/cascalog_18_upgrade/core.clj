(ns cascalog-18-upgrade.core
  (:use
   [cascalog [api] [workflow :only [fields]]])
  (:require
   [clojure.contrib [command-line :as cli] [logging :as log]]
   [cascalog [tap :as tap]])
  (:import
   [cascading.scheme TextDelimited]
   [cascading.tuple Fields])
  (:gen-class))

(defn delimited [fs cs]
  (TextDelimited. (fields fs) "\t" (into-array cs)))

(defn hfs-delimited [path fs cs]
  (tap/hfs-tap (delimited fs cs) path :sinkmode :replace))

(def gen-tuples
  [(range 3)
   (range 1 4)
   (range 2 5)])

(defn -main [& args]
  (let [[out-path] args
        sink (hfs-delimited out-path ["a" "b" "c"] (repeat 3 Integer))]
    (?<- "I don't plan correctly!"
         sink [?a ?b ?c]
         (gen-tuples :> ?a ?b ?c))))
