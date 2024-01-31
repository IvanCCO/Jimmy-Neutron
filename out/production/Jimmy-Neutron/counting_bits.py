# Essa foi a solução que fiz
# Criamos um array com a resposta final
# iteramos com o N + 1 para pegar o valor de N também
# transformamos (i) para binário(str) e usamos o método count("1")
# para contar a quantidade de 1's que tem no array
# e coloca no arr de resposta
def countBits(n: int):
    resposta = []

    for i in range(0, n + 1):
        binario = bin(i)
        resposta.append(binario.count("1"))

    return resposta


# Números binários tem base 2, então a quando a gente divide
# Um número binário por 2 é como se estivessemos /10 ou *10
# no padrão decimal, ou seja "mudando a virula", então
# nessa solução é criado um array para armazenar a resposta
# final e a resposta parcial que precisamos no decorrer,
# por exemplo para pegar o quantos 1s o número 5 tem fazemos o seguinte:
#
# 5 em binários = 0b101
# Quando shiftamos para esquerda fica 0b10
# 0b10 = 2 em decimal == "metade inteira de 5"
# então pegamos o valor do meu array na posição 2
# e somamos dependendo se for impár ou par,
# caso seja impár somamos 1 caso seja par não somamos nada.
# Essa solução tem Log(N).
# Inspirada nessa resposta
# https://leetcode.com/problems/counting-bits/solutions/656849/python-simple-solution-with-clear-explanation/
def countBitsMathBetterSolution(n: int):
    counter = [0]

    for i in range(1, n + 1):
        counter.append(counter[i >> 2] + (i % 2))

    return counter
