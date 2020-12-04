from setuptools import setup, find_packages


setup(
    name='advent-of-code-2020',
    version='0.1.0',
    description='Advent of Code 2020 solutions',
    author='Antti Juvonen',
    packages=find_packages(),
    python_requires='>=3.8',
    install_requires=['click', 'attrs', 'numpy']
)
