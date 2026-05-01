### Gerar chave para o jwt
`-join ((48..57 + 65..90 + 97..122 + 33..38) | Get-Random -Count 344 | % {[char]$_})`