# Вспомогательный скрипт для парсинга базы данных со стороннего ресурса #

from entry_classes import *


def get_cpus() -> list[CPUEntry]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(get_page('https://www.pc-kombo.com/us/components/cpus'), 'html.parser')

    cpus: list[CPUEntry] = []
    cpu_names: bs4.ResultSet = soup.find_all(class_='name')
    cpu_sockets: bs4.ResultSet = soup.find_all(class_='socket')
    cpu_prices: bs4.ResultSet = soup.find_all(class_='price')

    for i in range(len(cpu_names)):
        try:
            assert cpu_sockets[i].text in socket_tuple
        except AssertionError as e:
            continue

        try:
            cpus.append(CPUEntry(cpu_names[i],
                                 cpu_sockets[i],
                                 cpu_prices[i]))
        except ValueError as e:
            pass
    return cpus


def get_motherboards() -> list[MotherboardEntry]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/motherboards'), 'html.parser'
    )

    m_boards: list[MotherboardEntry] = []
    m_board_names: bs4.ResultSet = soup.find_all(class_='name')
    m_board_sockets: bs4.ResultSet = soup.find_all(class_='socket')
    m_board_prices: bs4.ResultSet = soup.find_all(class_='price')

    for i in range(len(m_board_names) // 500):
        try:
            assert m_board_sockets[i].text in socket_tuple
        except AssertionError as e:
            continue

        try:
            ram_info: dict = get_motherboard_ram_info(m_board_names[i].parent['href'])
        except ValueError as e:
            continue

        m_boards.append(MotherboardEntry(m_board_names[i],
                                         m_board_prices[i],
                                         m_board_sockets[i],
                                         ram_info))

    return m_boards


def get_rams() -> list[RAMEntry]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/rams'), 'html.parser'
    )

    rams: list[RAMEntry] = []
    ram_names: bs4.ResultSet = soup.find_all(class_='name')
    ram_prices: bs4.ResultSet = soup.find_all(class_='price')
    ram_sizes: bs4.ResultSet = soup.find_all(class_='size')
    ram_types: bs4.ResultSet = soup.find_all(class_='type')

    for i in range(len(ram_names)):
        try:
            assert ram_types[i].text.split('-')[0] in ram_type_tuple
        except AssertionError as e:
            continue

        rams.append(RAMEntry(ram_names[i],
                             ram_prices[i],
                             ram_types[i],
                             ram_sizes[i]))

    return rams


def get_drives() -> list[DriveEntry]:
    hdd_soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/hdds'), 'html.parser'
    )

    ssd_soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/ssds'), 'html.parser'
    )

    drives: list[DriveEntry] = []
    drive_names: bs4.ResultSet = hdd_soup.find_all(class_='name')
    drive_prices: bs4.ResultSet = hdd_soup.find_all(class_='price')
    drive_sizes: bs4.ResultSet = hdd_soup.find_all(class_='size')

    for i in range(len(drive_names)):
        drives.append(DriveEntry(
            drive_names[i],
            drive_prices[i],
            drive_sizes[i]
        ))

    drive_names = ssd_soup.find_all(class_='name')
    drive_prices = ssd_soup.find_all(class_='price')
    drive_sizes = ssd_soup.find_all(class_='size')

    for i in range(len(drive_names)):
        drives.append(DriveEntry(
            drive_names[i],
            drive_prices[i],
            drive_sizes[i]
        ))

    return drives


if __name__ == "__main__":
    print('\n'.join([str(drive) for drive in get_drives()]))
