# Вспомогательный скрипт для парсинга базы данных со стороннего ресурса #

from entry_classes import *
import _csv


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
                                 cpu_prices[i],
                                 cpu_sockets[i]
                                 ))
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


def get_power_units() -> list[PowerUnitEntry]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/psus'), 'html.parser'
    )

    units: list[PowerUnitEntry] = []
    unit_names: bs4.ResultSet = soup.find_all(class_='name')
    unit_prices: bs4.ResultSet = soup.find_all(class_='price')
    unit_voltages: bs4.ResultSet = soup.find_all(class_='watt')

    for i in range(len(unit_names)):
        units.append(PowerUnitEntry(unit_names[i],
                                    unit_prices[i],
                                    unit_voltages[i]))

    return units


def get_videocards() -> list[VideoCardEntry]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(
        get_page('https://www.pc-kombo.com/us/components/gpus'), 'html.parser'
    )

    cards: list[VideoCardEntry] = []
    card_names: bs4.ResultSet = soup.find_all(class_='name')
    card_prices: bs4.ResultSet = soup.find_all(class_='price')
    card_vram_sizes: bs4.ResultSet = soup.find_all(class_='vram')

    for i in range(len(card_names)):
        print(f'Getting videocard #{i + 1} of {len(card_names)}')
        cards.append(VideoCardEntry(card_names[i],
                                    card_prices[i],
                                    card_vram_sizes[i]))

    return cards


if __name__ == "__main__":
    with open('csv/rams.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'frequency', 'type', 'size'])
        writer.writerows([[ram.name, ram.price, ram.frequency, ram.type, ram.size] for ram in get_rams()])

    with open('csv/cpus.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'frequency', 'socket'])
        writer.writerows([[cpu.name, cpu.price, cpu.frequency, cpu.socket] for cpu in get_cpus()])

    with open('csv/drives.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'type', 'size'])
        writer.writerows([[drive.name, drive.price, drive.type, drive.size] for drive in get_drives()])

    with open('csv/psus.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'voltage'])
        writer.writerows([[psu.name, psu.price, psu.watts] for psu in get_power_units()])

    with open('csv/videocards.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'v_ram_size', 'frequency'])
        writer.writerows([[card.name, card.price, card.v_ram_size, card.frequency] for card in get_videocards()])

    with open('csv/motherboards.csv', 'w', encoding='UTF-8', newline='\n') as f:
        writer = _csv.writer(f)
        writer.writerow(['name', 'price', 'socket', 'ram_type', 'ram_slots_count'])
        writer.writerows([[board.name,
                           board.price,
                           board.socket,
                           board.ram_type,
                           board.ram_slots_count] for board in get_motherboards()])
