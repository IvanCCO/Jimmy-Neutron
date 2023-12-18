def countBits(x: int):
    resposta = []

    for i in range(0, x + 1):
        binario = bin(i)
        resposta.append(binario.count("1"))

    return resposta


print(countBits(5))
