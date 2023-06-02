package org.example

import org.apache.spark.sql.SparkSession

object CSVReaderJob {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder()
      .appName("CSVReaderJob")
      .getOrCreate()

    // Set the HDFS file path
    val filePath = "ofs://ozone/data/compute/sample_data.txt"

    // Read the CSV file into a DataFrame
    val data = spark.read
      .format("csv")
      .option("header", "false") // If the CSV file has a header row
      .option("delimiter", "\\t") // delim
      .load(filePath)

    // Perform operations on the DataFrame (e.g., print schema, show data)
    data.show()

    // Close the SparkSession
    spark.stop()
  }
}