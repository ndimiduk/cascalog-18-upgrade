(defproject cascalog-18-upgrade "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :repositories {"cloudera"
                 "https://repository.cloudera.com/content/repositories/releases/"}
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [org.apache.hadoop/hadoop-core "0.20.2-cdh3u1"]
                 [cascalog "1.8.0"]]
  :main cascalog-18-upgrade.core)
