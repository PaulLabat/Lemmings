#!/bin/bash
ocamlc -o sortie ParserXML.ml
rm *.cmi *.cmo
./sortie
rm sortie
java -jar Lemmings_NIC.jar
