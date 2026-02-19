# FindIT – Reimagining the Lost & Found

A digital Lost & Found solution designed for modern campuses. FindIT centralizes reporting and recovery into a streamlined Android application built with native technologies.

**Developed by:** Adibul Jabir  
**Course:** CSE 061 2212 – Software Development 3  
**Instructor:** Mushfiq Shahrier Shafi  

---

## Overview

FindIT addresses the operational inefficiencies of traditional lost and found systems. Instead of fragmented information across physical notice boards and informal channels, the application provides a centralized digital hub that simplifies item reporting and recovery.

The platform is designed to minimize stress, reduce delays, and improve campus-wide coordination.

---

## Problem Statement

Losing essential personal items leads to:

- Immediate stress and disruption  
- Productivity loss  
- Delayed academic or professional activities  

Traditional systems are ineffective because:

- Physical notice boards are frequently ignored  
- Information is scattered and disorganized  
- Manual coordination is slow and inefficient  

**Insight:** The challenge is operational, not technological. There is no unified, structured system to manage lost and found items effectively.

---

## Solution

FindIT serves as a pocket-sized recovery hub with the following value propositions:

### Centralized
A single platform for submitting and discovering all lost and found reports.

### Accessible
Available 24/7 through a mobile device.

### Structured Workflow
A simplified reporting and recovery process designed for usability and speed.

---

## User Experience

FindIT focuses on a seamless and intuitive reporting flow:

1. Open the application  
2. Browse lost and found listings  
3. Use the Floating Action Button (FAB) to add a lost or found item  
4. Tap **Contact** to directly access the reporter’s phone number  

The interface prioritizes clarity, speed, and minimal friction.

---

## Core Features

- Post Lost Items  
- Post Found Items  
- Centralized Item Feed  
- Direct Contact Access  
- Structured Reporting Workflow  

---

## Technical Stack

FindIT is built natively for Android using:

- Kotlin  
- XML (UI Layouts)  
- Room Database (Local persistence)  
- MVVM-inspired architecture principles  

The architecture ensures modularity, maintainability, and scalability.

---

## Engineering Approach

- Clean UI layout using XML  
- Local data persistence with Room  
- Activity-based navigation  
- Optimized reporting flow for minimal user friction  

The MVP focuses on reliability and functional clarity.

---

## Future Scope

The current version represents a minimum viable product. Planned enhancements include:

### Cloud Synchronization
Firebase integration for real-time multi-device data sync.

### Image Upload Support
Allow users to attach images for verification and faster identification.

### User Authentication
Secure login system with verified user profiles.

### Expanded Security Capabilities
Transition from a simple recovery tool to a comprehensive campus security support platform.

---

## Installation

1. Clone the repository  

   ```bash
   git clone https://github.com/your-username/findit.git
