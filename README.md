# SantanderCoders_Java
Projetos em Java para o Curso Santander Coders

O projeto consiste em um código para dada uma tabela exemplo - de resultados de futebol - criar a classificação dos times e um relatorio de partidas por time, todos em csv.

Exemplo de Classificação:

"Classifica��o","Club","Pontos","Jogos","Vitorias","Empates","Derrotas","Gols Pro","Gols Sofridos","Saldo de Gols","Ultima Partida"

"1","VASCO","64","38","20","5","13","108","92","16","CUI"
"2","FLUMINENSE","63","38","19","6","13","108","92","16","CORI"
"3","JUVENTUDE","62","38","19","5","14","115","121","-6","AMé"
"4","CEARá","62","38","20","2","16","115","104","11","CORI"

Exemplo de Relatório de Partida

"Data","Club1","Placar","x","Placar","Club2"
"2022-03-04","Internacional","0","x","Fortaleza","5"
"2022-03-14","Internacional","6","x","Fortaleza","6"
"2022-03-16","Internacional","4","x","Palmeiras","3"

Ambos exemplos foram gerados já utilizando o código.

A estrutura do projeto está da seguinte forma:

Basis -> Classe base Match(Partida) e Club(Time)
Reader -> File Handler dos arquivos contidos no Input
Generate - > Algoritmo de busca(Um falso binary search), de organização por partida(Organize) e de processamento da classificação(Core2)
Input -> Arquivos .csv e .txt de teste
OutPut -> Configuraçãod e saída dos arquivos
