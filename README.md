https://github.com/DolphinzAQT/clean-code/releases

# Clean Code Examples and Refactoring Techniques for Developers
[![Releases](https://img.shields.io/github/v/release/DolphinzAQT/clean-code?label=Releases&color=blue)](https://github.com/DolphinzAQT/clean-code/releases) [![License](https://img.shields.io/github/license/DolphinzAQT/clean-code)](https://github.com/DolphinzAQT/clean-code/blob/main/LICENSE) [![Build Status](https://img.shields.io/github/actions/workflow/status/DolphinzAQT/clean-code/ci.yml?branch=main&label=CI&color=green)](https://github.com/DolphinzAQT/clean-code/actions)

![Clean Code Banner](https://images.unsplash.com/photo-1515879218367-8466d910aaa4?ixlib=rb-4.0.3&q=80&w=1600&auto=format&fit=crop)

Demonstration of clean code principles with practical refactoring techniques covered with comprehensive tests. This repository collects patterns, anti-patterns, refactorings, and test suites so you can learn and practice on real examples.

Table of Contents
- About
- What you will learn
- Core principles
- Refactoring recipes (with examples)
- Tests and TDD
- Quick start
- Releases
- Project layout
- Contributing
- License
- Topics

About
This repo trades theory for practice. Each lesson shows an original messy implementation, a step-by-step refactor, and a test suite that proves behavior stays correct. The aim: improve readability, maintainability, and design while keeping behavior intact.

What you will learn
- How to spot code smells.
- How to apply refactoring patterns.
- How to write focused unit tests.
- How to use design patterns to remove conditionals.
- How to simplify APIs and reduce coupling.
- How to make code easier to review and extend.

Core principles
- Small functions: one task per function.
- Intent-revealing names: names say what code does.
- Single responsibility: modules do one job.
- Favor composition over inheritance where it fits.
- Keep tests fast, isolated, and deterministic.
- Use automation to keep design clean.

Refactoring recipes
Each recipe shows a before and after. Examples use short code snippets in JavaScript and Python where relevant. Tests show the expected behavior.

1) Rename for intent
Problem: variables or functions hide purpose.
Before:
```js
function a(n) {
  return n * 60;
}
```
After:
```js
function minutesToSeconds(minutes) {
  return minutes * 60;
}
```
Why: Names act as documentation. They reduce mental load during review.

2) Extract function
Problem: long function mixes high-level steps with details.
Before:
```py
def process_order(order):
    # validate
    if not order['items']:
        raise ValueError('empty order')
    # compute
    total = 0
    for i in order['items']:
        total += i['price'] * i['qty']
    # apply discount
    if order.get('discount'):
        total *= (1 - order['discount'])
    return total
```
After:
```py
def process_order(order):
    validate_order(order)
    total = compute_items_total(order['items'])
    total = apply_discount(total, order.get('discount'))
    return total
```
Why: Break tasks into named functions. Tests can target each function.

3) Replace conditional with polymorphism (or strategy)
Problem: large switch/case by type.
Before:
```js
if (shape.type === 'circle') {
  return Math.PI * shape.radius * shape.radius;
}
if (shape.type === 'square') {
  return shape.side * shape.side;
}
```
After (strategy):
```js
const areaCalculators = {
  circle: s => Math.PI * s.radius * s.radius,
  square: s => s.side * s.side
};
return areaCalculators[shape.type](shape);
```
Why: Adding a shape then requires only a new entry, not another branch.

4) Consolidate conditional
Problem: duplicated conditional logic across methods.
Pattern: pull the condition into a single helper or state object. This reduces duplication and lowers risk.

5) Introduce parameter object
Problem: long parameter lists.
Before:
```js
createUser(name, email, age, address, phone)
```
After:
```js
createUser({ name, email, age, address, phone })
```
Why: Named fields improve call sites and simplify adding new fields.

6) Move function (low coupling)
Problem: function lives in module A but uses data from module B more.
Action: move function to module B to reduce coupling and clarify ownership.

7) Make the tests drive the design
Use failing tests to guide refactor. Start with a failing unit test for the desired behavior. Then implement the smallest change to make it pass. Refactor while keeping tests green.

Examples and code walkthroughs
- "messages" module: shows replacing a big switch with a lookup table and tests for each message type.
- "pricing" module: shows stepwise refactor from long method to composed functions and pure helpers.
- "order processor": shows adding integration tests and using stubs to isolate external services.

Tests and TDD
- Tests live in tests/ with a mirrored structure to src/.
- Use a test runner (Jest for JavaScript, pytest for Python).
- Tests use fixtures for repeatable state.
- Each refactor includes tests that guard behavior.
- Fast unit tests sit alongside slower integration tests. Run units in CI and run integration tests in a scheduled pipeline.

Running tests (example)
JavaScript:
```bash
npm install
npm test
```
Python:
```bash
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
pytest -q
```

Quick start
- Clone the repo.
```bash
git clone https://github.com/DolphinzAQT/clean-code.git
cd clean-code
```
- Install dependencies per language folder (see each example folder README).
- Run unit tests and review failing tests to understand the original smell.
- Apply refactor steps in the markdown guides and re-run tests.

Releases
Download the packaged examples and runnable demos from the Releases page: https://github.com/DolphinzAQT/clean-code/releases

The Releases page contains compiled sample apps and scripts. Download the latest release archive and run the included script to run demos. Example:
```bash
# example commands; replace v1.0.0 and file name with the latest release
curl -L -o clean-code-v1.0.0.tar.gz https://github.com/DolphinzAQT/clean-code/releases/download/v1.0.0/clean-code-v1.0.0.tar.gz
tar -xzf clean-code-v1.0.0.tar.gz
cd clean-code-v1.0.0
chmod +x run-demo.sh
./run-demo.sh
```
The script runs small demo servers and sample refactor flows. If a release file does not match these names, check the Releases section for available files and their run instructions.

Project layout
- src/        — production examples and refactor targets
- tests/      — unit and integration tests
- docs/       — guided refactor walkthroughs
- examples/   — runnable small apps
- scripts/    — helper scripts for demos
- .github/    — CI and issue templates
- LICENSE

Contributing
- Open an issue for new examples or refactor suggestions.
- Create a branch per change: feat/ or fix/.
- Write tests that capture the original behavior before refactor.
- Push a PR with a clear description of the smell and steps taken.
- Keep changes small and focused.

Review checklist
- Does the change keep behavior?
- Are names intent-revealing?
- Are functions short and focused?
- Are tests isolated and fast?
- Is duplication reduced?

Images and resources
- Hero image: Unsplash (coding image).
- Diagrams in docs use simple SVG and ASCII flow diagrams.
- Each refactor walkthrough contains before/after code with diff-style snippets.

License
This repo uses the MIT license. See LICENSE for full terms.

Authors
- Maintainer: DolphinzAQT
- Contributors: open to the community

Topics
best-practices, clean-code, code-improvement, code-quality, code-review, code-smells, coding-standards, learning, maintainability, readability, refactoring, refactoring-techniques, software-craftsmanship, software-development, software-engineering, tdd, testing

Contact
For questions or suggestions open an issue or submit a pull request. The docs folder contains a contributor guide and style rules to help reviewers.

Badges reference
- Releases badge links to the releases page for quick access.
- CI badge shows test health on main branch.
- License badge links to the repository license file.