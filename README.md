# sparkds-mysql-oracle-drill
Sample project with read/write implementations for Mysql, Oracle, Drill

**DRILL**

* *__INSTALLATION__* - For Drill setup in embedded(standalone), distributed(clustered) mode with Zoo-Keeper for Ubuntu 16.04 (worked for 14.04 too), refer to 
[link](https://www.bogotobogo.com/Drill/Drill_Tutorial_Install_on_ubuntu_16_04.php) 

* *__COMMON CONFIGS__* -
  1. "extractHeader": true when reading csv. Else fails when reading in Spark as it reads the whole row as [c1, c2, c3 ..] resulting
  in unknown datatype.
  1. Set Option in Drill UI -> `planner.parser.quoting_identifiers` to " - This is to align with Spark default ". It can be overridden in Spark too.
  1. Configure hive storage plugin - Point to the hive warehouse directory, metastore.

* *__DRILL Distrubuted__* -
  1. Add IP against local-pc name when running locally (To fix pinging self issue in ZK)
  1. Add IP in zoo-keeper, drill-override.conf
  1. Start Zoo-Keeper, then run drillbit.sh

* *__NOTES__*:
  1. Write not supported for non-workspace ones. i.e., write only supported in local file system
  1. Read failing for mysql (maybe jdbc bug) - Need to be looked into
