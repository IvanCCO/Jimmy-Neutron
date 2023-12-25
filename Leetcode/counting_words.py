# Maximum Number of Words Found in Sentences
# Tem que contar o número de palavras levando em conta, que 
# cada palavra é separada por " " (espaco).
def count_words(words : list[str]):

  max_words = 0

  for word in words:
    words_count = len(word.split())
    if(words_count > max_words):
      max_words = words_count
  return max_words

# Essa propriedade max faz a mesma coisa que na outra funcao 
def count_words_reduce(words : list[str]):
  max_words = 0
  for word in words:
    max_words = max(max_words, len(word.split()))
  return max_words


