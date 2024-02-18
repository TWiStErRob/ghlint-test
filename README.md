# GitHub Actions validator

This is a CLI utility to validate GitHub Actions workflows files.

## Why?
There are many [other tools](#alternatives) checking the syntax of YAML files,
or validating against the [SchemaStore github-workflow shema][schemastore-workflow],
but none of them are tailored for easily writable custom semantic rules.
This tool aims to fill the gap.

It is heavily inspired by
[detekt](https://detekt.dev/),
[PSI](https://plugins.jetbrains.com/docs/intellij/psi.html),
and [Object Calisthenics](https://www.google.com/?q=Object%20Calisthenics).

## Usage

### Quick start

1. Copy [usage.yml](.github/workflows/usage.yml) to your repository to `.github/workflows/ghlint.yml`.
2. Change the `on:` trigger to your liking (usually `on: pull_request` or `on: push`).

### Troubleshooting

#### Advanced Security must be enabled for this repository to use code scanning.

```
Run github/codeql-action/upload-sarif@v3
  with:
    ...

RequestError [HttpError]: Advanced Security must be enabled for this repository to use code scanning.
{
    status: 403,
    response: {
        url: 'https://api.github.com/repos/<org>/<repo>/code-scanning/analysis/status',
        status: 403,
        data: {
            message: 'Advanced Security must be enabled for this repository to use code scanning.
```

https://docs.github.com/en/code-security/code-scanning/troubleshooting-code-scanning/advanced-security-must-be-enabled

## Alternatives

* [mpalmer/action-validator](https://github.com/mpalmer/action-validator)
  is a JSON schema validator for GitHub Actions including some additional checks, like glob validation.
* [yamllint](https://github.com/adrienverge/yamllint)
  is a syntax and formatting checker for YAML files.
* _If you know any others, feel free to PR._

[schemastore-workflow]: https://github.com/SchemaStore/schemastore/blob/master/src/schemas/json/github-workflow.json
